import axios from "axios";

export const getAllBook = async () => {
    try {
        const response = await axios.get('http://localhost:8080/books?name=');
        console.log(response);
        return response.data;
    } catch (error) {
        console.error('Error fetching all books:', error);
    }
}

export const addNewBook = async (book) => {
    try {
        await axios.post('http://localhost:8080/books', book);
        return true;
    } catch (error) {
        console.error('Error adding new book:', error);
        return false;
    }
}

export const removeBook = async (bookId) => {
    try {
        await axios.delete(`http://localhost:8080/books/${bookId}`);
        return true;
    } catch (error) {
        console.error('Error removing book:', error);
        return false;
    }
}

export const updateBook = async (bookId, updateBook) => {
    try {
        await axios.put(`http://localhost:8080/books/${bookId}`, updateBook);
        return true;
    } catch (error) {
        console.error('Error updating book:', error);
        return false;
    }
}

export const findById = async (bookId) => {
    try {
        const response = await axios.get(`http://localhost:8080/books/${bookId}`);
        return response.data;
    } catch (error) {
        console.error('Error finding book by id:', error);
        console.log(error);
    }
}