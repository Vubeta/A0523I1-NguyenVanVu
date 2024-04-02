import {useState} from "react";

function useClock() {
    const [time, setTime] = useState("");
    const [ampm, setampm] = useState("");

    //Function update time
    const updateTime = function () {
        let dateInfo = new Date();
        let hour = 0;
        // Lấy giá trị của giờ
        if (dateInfo.getHours() === 0) {
            hour = 12;
        } else if (dateInfo.getHours() > 12) {
            hour = dateInfo.getHours() - 12;
        } else {
            hour = dateInfo.getHours();
        }

        // Lấy giá trị của phút
        let minutes = dateInfo.getMinutes() < 10
            ? parseInt("0" + dateInfo.getMinutes())
            : dateInfo.getMinutes();

        //Lấy giá trị của giây
        let seconds = dateInfo.getSeconds() < 10
            ? "0" + dateInfo.getSeconds()
            : dateInfo.getSeconds();

        //Định dạng ngày
        let ampm = dateInfo.getHours() >= 12 ? "PM" : "AM";

        //Cập nhật state
        setampm(ampm)
        setTime(`${hour}:${minutes}:${seconds}`);
    };

    setInterval(function () {
        updateTime();
    }, 1000);

    return [time, ampm];
}

export default useClock;