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
        this.pinPercent = this.mobileMain.querySelector("[name='pinPercent']");
        this.mobileNameMain = this.mobileMain.querySelector("[name='mobileNameMain']");
        this.contentTempMain = this.mobileMain.querySelector("[name='contentTempMain']");
        this.contentSentMain = this.mobileMain.querySelector("[name='contentSentMain']");
        this.contentInboxMain = this.mobileMain.querySelector("[name='contentInboxMain']");
        this.draftMessageZone = this.mobileMain.querySelector("[name='draftMessageZone']");
        this.contentMessTemp = this.mobileMain.querySelector("[name='contentMessTemp']");
        this.contentMain = this.mobileMain.querySelector("[name='contentMain']");
        this.statusMobile = this.mobileMain.querySelector("[name='statusMobile']");
    }
    //Ẩn tất cả nội dung trong table (Điện thoại)
    hideAllTableData() {
        for (let i=0; i < this.columns.length; i++) {
            this.columns[i].classList.add("hide");
        }
        this.draftMessageZone.classList.remove("showDraft");
    }

    //Ẩn tên điện thoại ở màn hình chính
    hideMobileNameMain() {
        this.mobileNameMain.classList.add("hide");
        this.mobileNameMain.classList.remove("centerTwoDirection");
    }
    //Hiện tên điện thoại ở màn hình chính
    showMobileNameMain() {
        this.mobileNameMain.classList.remove("hide");
        this.mobileNameMain.classList.add("centerTwoDirection");
    }

    //Ẩn vùng hiển thị tin nhắn chờ (nơi hiển thị những tin nhắn chưa gửi)
    hideTempMessageZone() {
        this.contentTempMain.classList.add("hide");
    }
    //Hiện vùng hiển thị tin nhắn chờ (nơi hiển thị những tin nhắn chưa gửi)
    showTempMessageZone() {
        this.contentTempMain.classList.remove("hide");
    }

    //Ẩn vùng hiển thị tin nhắn đã gửi
    hideSentMessageZone() {
        this.contentSentMain.classList.add("hide");
    }
    //Hiện vùng hiển thị tin nhắn đã gửi
    showSentMessageZone() {
        this.contentSentMain.classList.remove("hide");
    }

    //Ẩn vùng hiển thị tin nhắn đã nhận
    hideInboxMessageZone() {
        this.contentInboxMain.classList.add("hide");
    }
    //Hiện vùng hiển thị tin nhắn đã nhận
    showInboxMessageZone() {
        this.contentInboxMain.classList.remove("hide");
    }

    //Ẩn vùng soạn tin nhắn
    hideDraftMessageZone() {
        this.draftMessageZone.classList.remove("showDraft");
        this.draftMessageZone.classList.add("hide");
    }
    //Hiện vùng soạn tin nhắn
    showDraftMessageZone() {
        this.draftMessageZone.classList.add("showDraft");
        this.draftMessageZone.classList.remove("hide");
    }

    //Ẩn ô soạn tin nhắn
    hideContentMessTemp() {
        this.contentMessTemp.classList.add("hide");
    }
    //Hiện ô soạn tin nhắn
    showContentMessTemp() {
        this.contentMessTemp.classList.remove("hide");
    }

    //Ẩn nội dung hiển thị chính
    hideContentMain() {
        this.contentMain.classList.add("hide");
    }
    //Hiện nội dung hiển thị chính
    showContentMain() {
        this.contentMain.classList.remove("hide");
    }

    //Ẩn thông báo trạng thái điện thoại
    hideStatusMobile() {
        this.statusMobile.classList.add("hide");
    }
    //Hiện thông báo trạng thái điện thoại
    showStatusMobile() {
        this.statusMobile.classList.remove("hide");
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
        const arrayObjects = [this.mobileNameMain,this.contentTempMain,
                                this.contentSentMain,this.contentInboxMain,
                                this.draftMessageZone,this.contentMessTemp,
                                this.contentMain,this.statusMobile];
        const arrayFunctionHide = [this.hideMobileNameMain, this.hideTempMessageZone,
                                this.hideSentMessageZone, this.hideInboxMessageZone,
                                this.hideDraftMessageZone, this.hideContentMessTemp,
                                this.hideContentMain, this.hideStatusMobile];
        const arrayFunctionShow = [this.showMobileNameMain, this.showTempMessageZone,
                                this.showSentMessageZone, this.showInboxMessageZone,
                                this.showDraftMessageZone, this.showContentMessTemp,
                                this.showContentMain, this.showStatusMobile];

        for (let i=0; i<arrayObjects.length; i++) {
            if (object.includes(arrayObjects[i])) {
                arrayFunctionShow[i]();
            } else {
                arrayFunctionHide[i]();
            }
        }
    }

    //Lưu tin nhắn chưa gửi vào bộ nhớ tạm (Khi tin nhắn chưa được gửi mà sử dụng các chức năng khác)
    setMemoryMessTemp() {
        if (this.contentMessTemp.value != '') {
            this.memoryMessTemp.push(this.contentMessTemp.value);
        }
        this.hideTempMessageZone();
        this.hideDraftMessageZone();
    }
    //Hiển thị tin nhắn chưa gửi và vùng soạn tin nhắn (Khi nhấn vào button 'DRAFT MESSAGE')
    getMemoryMessTemp() {
        this.hideAdvanced([this.contentMain, this.contentTempMain,
                                this.draftMessageZone, this.contentMessTemp]);
        for (let i=0; i<this.memoryMessTemp.length; i++) {
            this.contentTempMain.innerHTML += "<br/>" + this.memoryMessTemp[i];
        }
        this.showDraftMessageZone();
        this.hideMobileNameMain();
    }

    //Lưu tin nhắn nhận được vào hộp thư đến
    setMemoryMessInbox(content) {
        if (content != '') {
            this.memoryMessInbox.push(content);
        }
    }
    //Hiển thị hộp thư đến
    getMemoryMessInbox() {
        this.hideAdvanced([this.contentMain, this.contentInboxMain]);
        this.hideDraftMessageZone();
        for (let i=0; i<this.memoryMessInbox.length; i++) {
            this.contentInboxMain.innerHTML += "<br/>" + this.memoryMessInbox[i];
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
        this.hideAdvanced([this.contentMain, this.contentSentMain]);
        this.hideDraftMessageZone();
        for (let i=0; i<this.memoryMessSent.length; i++) {
            this.contentSentMain.innerHTML += "<br/>" + this.memoryMessSent[i];
        }
    }

    powerPhone() {
        if (this.statusOn == false) {
            this.statusOn = true;
            for (let i=0; i<this.columns.length; i++) {
                this.columns[i].classList.remove("hide");
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
            this.statusMobile.innerHTML = "Your Phone is turning on.";
        } else {
            this.hideAdvanced([this.contentMain, this.statusMobile]);
            this.statusMobile.innerHTML = "Your Phone is turning off.";
            setTimeout(function () {
                this.hideStatusMobile();
                this.hideContentMain();
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

    test() {
        this.mobileNameMain.innerHTML = "HELLO";
        this.mobileNameMain.classList.remove("hide");
    }
};