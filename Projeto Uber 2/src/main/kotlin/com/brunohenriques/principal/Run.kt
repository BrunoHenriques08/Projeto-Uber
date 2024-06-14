enum class RunStatus {
    PENDING, IN_PROGRESS, COMPLETED
}

class Run (var car: Car, var driver: Driver, var client: Client, var status: RunStatus = RunStatus.PENDING) {
    fun startRun() {
        status = RunStatus.IN_PROGRESS
        println("Run started: ${car.make} driven by ${driver.name} for client ${client.name}")
        println("Going from ${car.localization} to ${client.localization}")
    }

    fun completeRun() {
        status = RunStatus.COMPLETED
        println("Run completed for client ${client.name}")
    }
}

