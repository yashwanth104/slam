package com.geekoder.slamee;


public class Slamee {

    private String _name, _nick, _day, _month, _year, _phone,_fb,_hobby,_dear,_place,_scrt,_live,_love,_dream,_inspire,_you,_msg, _back;
    private byte[] _image,_sign;
    private int _id ;


	public Slamee (int id, String name, String nick,  String day, String month,String year,String back,String phone,String fb,String hobby,String dear,String place,String scrt,String live,String love,String dream,String inspire,String you,String msg, byte[] image) {
        _id = id;
        _name = name;
        _nick = nick;
        _day = day;
        _month = month;
        _year = year;
        _back = back;
        _phone = phone;
        _fb = fb;
        _hobby = hobby;
        _dear= dear;
        _place = place;
        _scrt = scrt;
        _love = love;
        _live = live;
        _dream = dream;
        _inspire = inspire;
        _you = you;
        _msg = msg;
        _image = image;
        //_sign = sign;
    }

    public int getId() { return _id; }

    public String getName() {
        return _name;
    }

    public String getNick() {
        return _nick;
    }
    public String getday() {
        return _day;
    }
    public String getmonth() {
        return _month;
    }
    public String getyear() {
        return _year;
    }
    public String getback(){
		return _back;
	}
    public String getPhone() {
        return _phone;
    }

    public String getfb() {
        return _fb;
    }

    public String gethobby() {
        return _hobby;
    }
    public String getdear() {
        return _dear;
    }
    public String getplace() {
        return _place;
    }
    public String getscrt() {
        return _scrt;
    }
    public String getlive() {
        return _live;
    }
    public String getlove() {
        return _love;
    }
    public String getdream() {
        return _dream;
    }
    public String getinspire() {
        return _inspire;
    }
    public String getyou() {
        return _you;
    }
    public String getmsg() {
        return _msg;
    }

    public byte[] getImage() {
    	return _image;
    	}
	
    /*public byte[] getSign(){
    	return _sign;
    }*/
}
