class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next, prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private Movie head, tail;

    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void removeMovieByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void searchMovieByDirectorOrRating(String director, double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void updateMovieRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayMoviesForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayMoviesBackward() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagement {
    public static void main(String[] args) {
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();

        movieList.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addMovieAtEnd("The Matrix", "Wachowski Sisters", 1999, 8.7);
        
        System.out.println("Movies in Forward Order:");
        movieList.displayMoviesForward();

        System.out.println("Movies in Reverse Order:");
        movieList.displayMoviesBackward();

        System.out.println("Searching for movies directed by Christopher Nolan:");
        movieList.searchMovieByDirectorOrRating("Christopher Nolan", 0);

        System.out.println("Updating rating for The Matrix:");
        movieList.updateMovieRating("The Matrix", 9.0);
        movieList.displayMoviesForward();

        System.out.println("Removing movie: Inception");
        movieList.removeMovieByTitle("Inception");
        movieList.displayMoviesForward();
    }
}

