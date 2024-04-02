let arr = [7, 2, 4, 9, 11, -1, 6, -11];
//1. Tạo một mảng mới chứa các số lớn hơn 5 từ mảng ban đầu.
let newArr1 = arr.filter((number) => number > 5);
console.log(newArr1);

//2. Sử dụng arrow function và reduce để tính tổng các phần tử trong mảng.
let newArr2 = arr.reduce((previousValue, currentValue) => previousValue + currentValue);
console.log(newArr2);

//3. Kiểm tra 1 mảng có chứa số V hay không nếu có trả về V không thì trả về "không tìm thấy".
let checkExists = (V) => {
    let result = arr.find((a) => a === V);
    return result !== undefined ? result : "Không tìm thấy";
}
console.log(checkExists(-11));

//4. Kiểm tra 1 mảng tất cả các phần tử trong mảng đó có lớn hơn 0 hay không?.
let checkGreater = () => {
    let result = arr.filter((number) => number > 0);
    return result.length === arr.length ? "All element is greater than 0" : "All element isn't greater than 0";
}
console.log(checkGreater());
//5. Tìm phần tử đầu tiên trong mảng lớn hơn 3.
console.log(arr.find((number) => number > 3));

//6. Sử dụng destructuring với rest parameter để trích xuất phần tử đầu tiên vào biến "first" và các phần tử còn lại vào một mảng mới "rest".
let [first, ...rest] = arr;
console.log("first: ", first);
console.log("rest: ", rest);
//7. Sử dụng destructuring để trích xuất các giá trị "name" và "age" từ một mảng chứa các đối tượng "person".
const person = [
    {
        id: 1, name: "Hai", age: 30
    }, {
        id: 2, name: "Thien", age: 25
    }, {
        id: 3, name: "Tho", age: 29
    }
];

for (let {name, age} of person) {
    console.log("Name: ", name, ", Age: ", age);
}
//8. Sử dụng Rest parameter và Spread operator để tạo một hàm nhận vào danh sách các số và trả về tổng của chúng.
function sum(...args) {
    let total = 0;
    for (const num of args) {
        total += num;
    }
    return total;
}

console.log("Sum: ", sum(...arr));
//9. Sử dụng Rest parameter để nhận vào một danh sách tên và trả về chuỗi định dạng "Welcome, [tên1], [tên2], [tên3], ..." cho tất cả các tên.
function welc(...array){
    return `Welcome, ${array.join(", ")}`;
}

console.log(welc(...person.map(p => p.name)));
//10. Tạo một đối tượng "book" với thuộc tính "title", "author" và "pages" bằng cách sử dụng Enhanced object literals.
// Đối tượng "book" cũng có phương thức "displayInfo" để in ra thông tin về sách.
const book = {
    title: "The Great Gatsby",
    author: "F. Scott Fitzgerald",
    pages: 218,
    displayInfo(){
        console.log(`Title: ${this.title}\nAuthor: ${this.author}\nPages: ${this.pages}`);
    }
}
book.displayInfo();