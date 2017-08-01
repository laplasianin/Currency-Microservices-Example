package currency

import currency.data.Currency
import groovyx.gpars.GParsPool

import java.time.LocalDate

class CurrencyService {

    def cbrCurrencyParserService
    def currencyStorageService

    List<Currency> retrieve(LocalDate date = LocalDate.now()) {
        def startMonth = date.withDayOfMonth(1)

        def monthRange = startMonth..date

        List<Currency> fromStorage = currencyStorageService.findIn(monthRange)

        List<LocalDate> existedData = fromStorage.collect { it.date }
        List<LocalDate> missedData = monthRange - existedData

        GParsPool.withPool {

            List<Currency> toSave = missedData.collectParallel cbrCurrencyParserService.&parse

            currencyStorageService.save(toSave)

            fromStorage += toSave
        }

        fromStorage.sort { it.date }
        fromStorage
    }
}
