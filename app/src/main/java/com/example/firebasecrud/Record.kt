package com.example.firebasecrud

class Record {

    var id: String? = null
    var name: String? = null
    var age: String?=null
    var address: String? = null

    constructor()

    constructor(id: String, name: String, age: String, address: String) {
        this.id = id
        this.name = name
        this.age = age
        this.address = address
    }

    constructor(name: String, age: String, address: String) {
        this.name = name
        this.age= age
        this.address = address

    }

    fun getUserName(): String? {
        return name
    }

    fun getUserAge(): String? {
        return age
    }

    fun getUserAddress(): String? {
        return address
    }

}