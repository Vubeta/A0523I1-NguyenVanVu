import {initializeApp} from "firebase/app";
import {getStorage} from "firebase/storage";

const firebaseConfig = {
    apiKey: "AIzaSyAD0EhJPgZllKsFU4I5w4BjkqlKdXm-qmA",
    authDomain: "tutorial-f1e49.firebaseapp.com",
    projectId: "tutorial-f1e49",
    storageBucket: "tutorial-f1e49.appspot.com",
    messagingSenderId: "1044751732564",
    appId: "1:1044751732564:web:51d5c38dd85757841582c1",
    measurementId: "G-Z2Z4CP565D"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

export const storage = getStorage(app);
// export {storage, database};