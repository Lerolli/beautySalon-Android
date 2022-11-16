package com.example.beautysalon_android.ServicesModule

class Service(name: String?, imageURL: String?, price: Int?) {
    val name = name
    val imageURL = imageURL
    val price = price
}


final class ServicesViewModel {
    var services = mutableListOf<Service>()

    fun getServices() {
        services.add(Service(name = "Бровки", imageURL = "", price = 1200))
        services.add(Service(name = "Губки", imageURL = "", price = 1200))
        services.add(Service(name = "Маникюр", imageURL = "", price = 1200))
    }

}