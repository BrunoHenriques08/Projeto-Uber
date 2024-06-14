fun main() {
    var locClient = Localization("1234", "12312")
    var locDriver = Localization("3456", "34566")


    var driver1 = Driver("Jose", "12345", null, null)
    var car1 = Car("BMW", "1 series", "black", driver1, null, locDriver)
    var client1 = Client("Filipe", 1, null, locClient)


    var run1 = Run(car1, driver1, client1)


    car1.run = run1
    driver1.car = car1
    driver1.run = run1

    client1.run = run1

    //Inicia a corrida
    run1.startRun()

    //Completa a corrida
    run1.completeRun()

    println("Client: ${client1.name}, Run status: ${client1.run?.status}")
}


