package in.kinshuk.rpi.batasia.gpio

import com.pi4j.io.gpio.{PinState, RaspiPin, GpioFactory}

/**
 * Created by kinshuk.bairagi on 26/02/15.
 */
object GpioService {

  val instance = GpioFactory.getInstance()

  //  val pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,  PinState.LOW)

  def shutdown(): Unit = {
    // stop all GPIO activity/threads by shutting down the GPIO controller
    // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
    instance.shutdown()
  }

}
