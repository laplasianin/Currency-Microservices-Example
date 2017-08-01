package currency

import currency.data.Currency
import grails.gorm.transactions.Transactional

import java.time.LocalDate

@Transactional
class CurrencyStorageService {

    List<Currency> findIn(List<LocalDate> dates) {
        Currency.findAllByDateInRange(dates)
    }

    List<Currency> save(List<LocalDate> dates) {
        Currency.saveAll(dates)
    }
}
