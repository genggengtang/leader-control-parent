/**
 * Created by billJiang on 2017/1/12.
 */

function LoginValidator(config) {
    this.code = config.code;
    this.message = config.message;
    this.username = config.username;
    this.passwd = config.passwd;
    this.captcha=config.captcha||"captcha";
    this.initValidator();
}

LoginValidator.prototype.initValidator = function () {
    if (!this.code)
        return;
    if(this.code==0){
        this.addPasswordErrorMsg();
    }else if(this.code==-1){
        this.addUserNameErrorStyle();
        this.addUserNameErrorMsg();
    }else if(this.code==-2){
        this.addPasswordErrorStyle();
        this.addPasswordErrorMsg();
    }else if(this.code==-3){
        this.addUserNameErrorStyle();
        this.addPasswordErrorStyle();
        this.addPasswordErrorMsg();
    }else if(this.code==-4){
        this.addCaptchaErrorStyle();
        this.addCaptchaErrorMsg();
    }
    return;
}

LoginValidator.prototype.addUserNameErrorStyle = function () {
    this.addErrorStyle(this.username);
}

LoginValidator.prototype.addPasswordErrorStyle = function () {
    this.addErrorStyle(this.passwd);
}

LoginValidator.prototype.addCaptchaErrorStyle = function () {
    this.addErrorStyle(this.captcha);
}

LoginValidator.prototype.addCaptchaErrorMsg = function () {
    this.addErrorMsg(this.captcha);
}



LoginValidator.prototype.addUserNameErrorMsg = function () {
    this.addErrorMsg(this.username);
}

LoginValidator.prototype.addPasswordErrorMsg = function () {
    this.addErrorMsg(this.passwd);
}


LoginValidator.prototype.addErrorMsg=function(field){
    $("input[name='"+field+"']").parent().append('<small  data-bv-validator="notEmpty" data-bv-validator-for="'+field+'" class="help-block">' + this.message + '</small>');
}

LoginValidator.prototype.addErrorStyle=function(field){
    $("input[name='" + field + "']").parent().addClass("has-error");
}





