//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var locClient = Localization("1234", "12312")
    var locDriver = Localization("3456", "34566")
    var car1 = Car("bmw", "1 series", "black", locDriver)
    var driver1 = Driver("Jose", "12345")
    var client1 = Client("Filipe", 1, locClient)


}