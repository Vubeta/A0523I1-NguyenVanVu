class Mobile {
    constructor(idPhone, mobileMain) {
        this.idPhone = idPhone;
        this.mobileMain = mobileMain;
        this.memoryMessTemp = [];
        this.memoryMessInbox = [];
        this.memoryMessSent = [];
        this.statusOn = false;
        this.statusDraftTemp = false;
        this.statusPinCharging = false;

        this.columns = this.mobileMain.getElementsByTagName("td");
        this.pinPercent = this.mobileMain.querySelector(".pinPercent");
        this.mobileNameMain = this.mobileMain.querySelector(".mobileNameMain");
        this.contentShowMain = this.mobileMain.querySelector(".contentShowMain");
        this.draftMessageZone = this.mobileMain.querySelector("td[data-name='draftMessageZone']");
        this.contentMessTemp = this.mobileMain.querySelector("[name='contentMessTemp']");
        this.contentMain = this.mobileMain.querySelector("td[data-name='contentMain']");
        this.statusMobile = this.mobileMain.querySelector(".statusMobile");
    }

    //

    //Ẩn tất cả nội dung trong table (Điện thoại)
    hideAllTableData() {
        for (let i=0; i < this.columns.length; i++) {
            this.columns[i].style.display = "none";
        }
        this.draftMessageZone.style.display = "none";
        this.draftMessageZone.style.removeProperty("border-top");
        this.draftMessageZone.style.removeProperty("align-items");
        this.draftMessageZone.style.removeProperty("justify-content");
        this.draftMessageZone.style.removeProperty("height");
    }

    //Ẩn tên điện thoại ở màn hình chính
    hideMobileNameMain() {
        this.mobileNameMain.style.display = "none";
        this.mobileNameMain.style.removeProperty("justify-content");
        this.mobileNameMain.style.removeProperty("align-items");
        this.mobileNameMain.style.removeProperty("height");
    }
    //Hiện tên điện thoại ở màn hình chính
    showMobileNameMain() {
        this.mobileNameMain.style.display = "flex";
        this.mobileNameMain.style.justifyContent = "center";
        this.mobileNameMain.style.alignItems = "center";
        this.mobileNameMain.style.height = "100%";
    }

    //Ẩn vùng hiển thị tin nhắn chờ, gửi, nhận
    hideMainMessageZone() {
        this.contentShowMain.style.display = "none";
    }
    //Hiện vùng hiển thị tin nhắn chờ, gửi, nhận
    showMainMessageZone() {
        this.contentShowMain.style.removeProperty("display");
    }

    //Ẩn vùng soạn tin nhắn
    hideDraftMessageZone() {
        this.draftMessageZone.style.display = "none";
        this.draftMessageZone.style.removeProperty("border-top");
        this.draftMessageZone.style.removeProperty("align-items");
        this.draftMessageZone.style.removeProperty("justify-content");
        this.draftMessageZone.style.removeProperty("height");
    }
    //Hiện vùng soạn tin nhắn
    showDraftMessageZone() {
        this.draftMessageZone.style.display = "flex";
        this.draftMessageZone.style.borderTop = "1px solid black";
        this.draftMessageZone.style.alignItems = "center";
        this.draftMessageZone.style.justifyContent = "center";
        this.draftMessageZone.style.height = "100%";
    }

    //Ẩn ô soạn tin nhắn
    hideContentMessTemp() {
        this.contentMessTemp.style.display = "none";
    }
    //Hiện ô soạn tin nhắn
    showContentMessTemp() {
        this.contentMessTemp.style.removeProperty("display");
    }


    //Ẩn nội dung hiển thị chính
    hideContentMain() {
        this.contentMain.style.display = "none";
    }
    //Hiện nội dung hiển thị chính
    showContentMain() {
        this.contentMain.style.removeProperty("display");
    }

    //Ẩn thông báo trạng thái điện thoại
    hideStatusMobile() {
        this.statusMobile.style.display = "none";
        this.statusMobile.style.removeProperty("justify-content");
        this.statusMobile.style.removeProperty("align-items");
        this.statusMobile.style.removeProperty("height");
    }
    //Hiện thông báo trạng thái điện thoại
    showStatusMobile() {
        this.statusMobile.style.display = "flex";
        this.statusMobile.style.justifyContent = "center";
        this.statusMobile.style.alignItems = "center";
        this.statusMobile.style.height = "100%";
    }

    //Giảm pin đi 1%
    reducePin1Percent() {
        this.pinPercent.innerHTML = parseInt(this.pinPercent.innerHTML)-1 + "%";
    }

    //Tăng pin lên 1% sau 1second
    creasePinPercent() {
        let pinValue = parseInt(this.pinPercent.innerHTML);
        if (pinValue==100) {
            this.statusPinCharging = true;
            return;
        } else {
            this.pinPercent.innerHTML = ++pinValue + "%";
        }
        setTimeout(this.creasePinPercent.bind(this), 1000);
    }

    //Ngoại trừ object[...], còn lại đều ẩn đi
    hideAdvanced(object) {
        const arrayObjects = [this.mobileNameMain, this.contentShowMain,
                                this.draftMessageZone,this.contentMessTemp,
                                this.contentMain, this.statusMobile];
        const arrayFunctionHide = [this.hideMobileNameMain, this.hideMainMessageZone,
                                this.hideDraftMessageZone, this.hideContentMessTemp,
                                this.hideContentMain, this.hideStatusMobile];
        const arrayFunctionShow = [this.showMobileNameMain, this.showMainMessageZone,
                                this.showDraftMessageZone, this.showContentMessTemp,
                                this.showContentMain, this.showStatusMobile];

        for (let i=0; i<arrayObjects.length; i++) {
            if (object.includes(arrayObjects[i])) {
                arrayFunctionShow[i].call(this);
            } else {
                arrayFunctionHide[i].call(this);
            }
        }
    }

    //Lưu tin nhắn chưa gửi vào bộ nhớ tạm (Khi tin nhắn chưa được gửi mà sử dụng các chức năng khác)
    setMemoryMessTemp() {
        if (this.contentMessTemp.value != '') {
            this.memoryMessTemp.push(this.contentMessTemp.value);
        }
    }
    //Hiển thị tin nhắn chưa gửi và vùng soạn tin nhắn (Khi nhấn vào button 'DRAFT MESSAGE')
    getMemoryMessTemp() {
        if(this.statusOn == false) {
            return;
        }
        this.hideAdvanced([this.contentMain, this.contentShowMain,
                                this.draftMessageZone, this.contentMessTemp]);
        this.contentShowMain.innerHTML = `<h3 align="center"><strong>DRAFT MESSAGE</strong></h3>`;
        for (let i=0; i<this.memoryMessTemp.length; i++) {
            this.contentShowMain.innerHTML += "<br/><strong>" + this.memoryMessTemp[i] + "</strong><br/>" +
                getCurrentDateTime() + "<br/>";
        }
    }

    //Lưu tin nhắn nhận được vào hộp thư đến
    setMemoryMessInbox(content) {
        if (content != '') {
            this.memoryMessInbox.push(content);
        }
    }
    //Hiển thị hộp thư đến
    getMemoryMessInbox() {
        if(this.statusOn == false) {
            return;
        }
        this.hideAdvanced([this.contentMain, this.contentShowMain]);
        this.contentShowMain.innerHTML = `<h3 align="center"><strong>INBOX MESSAGE</strong></h3>`;
        for (let i=0; i<this.memoryMessInbox.length; i++) {
            this.contentShowMain.innerHTML += "<br/><strong>" + this.memoryMessInbox[i] + "</strong><br/>" +
                getCurrentDateTime() + "<br/>";
        }
    }

    //Lưu tin nhắn đã gửi vào hộp thư đã gửi
    setMemoryMessSent(content) {
        if (content != '') {
            this.memoryMessSent.push(content);
        }
    }
    //Hiển thị hộp thư đã gửi
    getMemoryMessSent() {
        if(this.statusOn == false) {
            return;
        }
        this.hideAdvanced([this.contentMain, this.contentShowMain]);
        this.contentShowMain.innerHTML = `<h3 align="center"><strong>SENT MESSAGE</strong></h3>`;
        for (let i=0; i<this.memoryMessSent.length; i++) {
            this.contentShowMain.innerHTML += "<br/><strong>" + this.memoryMessSent[i] + "</strong><br/>" +
                                                getCurrentDateTime() + "<br/>";
        }
    }

    powerPhone() {
        if (this.statusOn == false) {
            this.statusOn = true;
            for (let i=0; i<this.columns.length; i++) {
                this.columns[i].style.removeProperty("display");
            }
            this.hideAdvanced([this.contentMain, this.mobileNameMain]);
        } else {
            this.statusOn = false;
            this.hideAllTableData();
        }
    }

    // Kiểm tra trạng thái điện thoại bật hay tắt
    checkStatusPhone() {
        if (this.statusOn == true) {
            this.hideAdvanced([this.contentMain, this.statusMobile]);
            // this.hideDraftMessageZone();
            this.statusMobile.innerHTML = "Your " + this.idPhone + " is turning on.";
        } else {
            this.hideAdvanced([this.contentMain, this.statusMobile]);
            this.statusMobile.innerHTML = "Your " + this.idPhone + " is turning off.";
            setTimeout(function () {
                this.hideStatusMobile();
            }.bind(this),3000);
        }
    }

    // Sạc pin
    chargingPhone() {
        if(this.statusPinCharging == false) {
            this.creasePinPercent();
        }
        this.statusPinCharging = true;
    }
}