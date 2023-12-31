package nrs.sankarsana.bookstore.repository.table

import nrs.sankarsana.bookstore.dto.BookMovement
import nrs.sankarsana.bookstore.dto.BookMovementType
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.jodatime.date

object BooksMovementTable : IntIdTable("books_movement") {
    val date = date("date")
    val bookId = integer("book_id").index()
    val type = varchar("type", 10)
    val quantity = integer("quantity")
    val version = integer("version").default(0)
}

class BookMovementEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<BookMovementEntity>(BooksMovementTable)

    var date by BooksMovementTable.date
    var bookId by BooksMovementTable.bookId
    var type by BooksMovementTable.type
    var quantity by BooksMovementTable.quantity
}

fun BookMovementEntity.toDomain() = BookMovement(
    id = id.value,
    date = date,
    bookId = bookId,
    type = BookMovementType.valueOf(type),
    quantity = quantity,
)