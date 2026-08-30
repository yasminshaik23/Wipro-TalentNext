function searchBooks() {

    var bookName = prompt("Enter the book name to search:");

    if (bookName !== null && bookName.trim() !== "") {

        var books = document.querySelectorAll(".book");
        var found = false;

        books.forEach(function(book) {

            var title =
                book.querySelector("h3").textContent.toLowerCase();

            if (title.includes(bookName.toLowerCase())) {

                book.scrollIntoView({
                    behavior: "smooth",
                    block: "center"
                });

                book.style.boxShadow = "0 0 15px black";

                setTimeout(function() {
                    book.style.boxShadow = "";
                }, 2000);

                found = true;
            }
        });

        if (!found) {
            alert("Book not found.");
        }
    }
}


function downloadPage() {

    var content = document.documentElement.outerHTML;

    var file = new Blob(
        [content],
        { type: "text/html" }
    );

    var link = document.createElement("a");

    link.href = URL.createObjectURL(file);
    link.download = "OnlineBookStore.html";

    link.click();

    URL.revokeObjectURL(link.href);
}


function printPage() {

    window.print();
}


function addFavorite() {

    alert("Book added to favorites ❤️");
}