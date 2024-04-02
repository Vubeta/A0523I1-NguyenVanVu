import useClock from "./useClock";
import React from "react";

function MyClock() {
    //Gọi custom hook để sử dụng
    const [time, ampm] = useClock();
    return (
        <div id={"Clock-style"}>
            {time}
            <span> {ampm}</span>
        </div>
    );
}

export default MyClock;