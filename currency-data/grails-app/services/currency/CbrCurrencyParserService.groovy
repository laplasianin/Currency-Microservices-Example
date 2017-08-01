package currency

import currency.data.Currency
import grails.gorm.transactions.Transactional
import groovyx.net.http.HTTPBuilder

import java.text.DecimalFormat
import java.text.NumberFormat
import java.time.LocalDate

import static java.time.format.DateTimeFormatter.ofPattern

class CbrCurrencyParserService {

    private static String url = "https://www.cbr.ru/currency_base/daily.aspx";

    Currency parse(LocalDate date) {
        def dateFormatted = date.format(ofPattern("dd.MM.yyyy"))
        def currency = new HTTPBuilder()
                .get(uri: "$url?date_req=$dateFormatted")
                .'**'.find { it.@class == 'data' }
                .'**'.findAll { it.'**'.find { it.text() in ['EUR', 'USD'] } }
                .collect { it.'**'.find { it.text() in ['EUR', 'USD'] } }
                .sort { it.text() }
                .collect { bdFormatter().parse(it.parent().children()[4].text()) }
                .unique()

        BigDecimal eur = currency[0]
        BigDecimal usd = currency[1]

        new Currency(
                date: date,
                usd: usd,
                eur: eur)
    }

    private DecimalFormat bdFormatter() {
        Locale in_ID = new Locale("ru", "RU")
        DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(in_ID)
        nf.setParseBigDecimal(true)
        nf
    }

}
