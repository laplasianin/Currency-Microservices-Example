package currency.data

import java.time.LocalDate

class BootStrap {

    def init = { servletContext ->

        LocalDate.metaClass.next << { -> delegate.plusDays(1) }

    }
    def destroy = {
    }
}
