package in.kinshuk.rpi.batasia.services

import com.pi4j.io.gpio.{PinState, RaspiPin}
import in.kinshuk.rpi.batasia.gpio.GpioService

/**
 * Created by kinshuk.bairagi on 28/02/15.
 */
object DancingLights {

  lazy val gpio = GpioService.instance

  def dance(): Unit = {
    val pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW)
    val pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW)
    val pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW)
    val pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW)

    /**
     * Do Dance!
     */
    pin1.high()
    Thread.sleep(200)
    pin2.high()
    Thread.sleep(200)
    pin3.high()
    Thread.sleep(200)
    pin4.high()
    Thread.sleep(200)
    val pin1Blink = pin1.blink(200, 200)
    val pin2Blink = pin2.blink(200, 200)
    val pin3Blink = pin3.blink(200, 200)
    val pin4Blink = pin4.blink(200, 200)
    Thread.sleep(2000)
    pin1Blink.cancel(true)
    pin2Blink.cancel(true)
    pin3Blink.cancel(true)
    pin4Blink.cancel(true)
    pin1.high()
    pin2.high()
    pin3.high()
    pin4.high()
    Thread.sleep(2000)
    pin1.low()
    Thread.sleep(200)
    pin2.low()
    Thread.sleep(200)
    pin3.low()
    Thread.sleep(200)
    pin4.low()
    Thread.sleep(200)

  }

}
