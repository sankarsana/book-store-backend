package nrs.sankarsana.bookstore.di

import nrs.sankarsana.bookstore.repository.BooksRepository
import nrs.sankarsana.bookstore.service.*
import org.koin.dsl.module

val booksModule = module {
    factory { GetBooksController(get()) }
    factory { GetBooksUseCase(get()) }
    factory { BooksDeliveryService(get()) }
    factory { BooksRepository() }

    factory { PostBookController(get()) }
    factory { AddNewBookUseCase(get()) }
}
