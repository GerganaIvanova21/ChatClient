package com.example.chatappclient.server

import java.io.IOException
import java.net.Socket
import kotlin.concurrent.thread

class TcpClient(private val serverIp: String, private val serverPort: Int) {
    private var socket: Socket? = null

    fun connect() {
        if (socket == null || socket?.isClosed == true) {
            try {
                socket = Socket(serverIp, serverPort)
                println("Успешна връзка със сървъра!")
                startListening()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            println("Socket вече е инициализиран.")
        }
    }

    fun sendMessage(message: String) {
        if (socket != null && !socket!!.isClosed) {
            try {
                val outputStream = socket!!.getOutputStream()
                outputStream.write(message.toByteArray())
                outputStream.flush()
            } catch (e: IOException) {
                e.printStackTrace()
                close() // Затваряне на сокета при грешка
            }
        } else {
            println("Socket не е инициализиран или е затворен.")
        }
    }

    private fun receiveMessage(): String? {
        if (socket != null && !socket!!.isClosed) {
            try {
                val inputStream = socket!!.getInputStream()
                val byteArray = ByteArray(1024)
                val bytesRead = inputStream.read(byteArray)
                return String(byteArray.copyOfRange(0, bytesRead))
            } catch (e: IOException) {
                e.printStackTrace()
                close() // Затваряне на сокета при грешка
            }
        } else {
            println("Socket не е инициализиран или е затворен.")
        }
        return null
    }

    private fun startListening() {
        thread(start = true) {
            try {
                while (true) {
                    if (socket != null && !socket!!.isClosed) {
                        val message = receiveMessage()
                        if (message == null) {
                            println("Не е получено съобщение.")
                            break
                        }
                        when (message) {
                            "createUser" -> println("Received createUser command")
                            "userLogIn:" -> println("Handle command2")
                            "status:true:" -> println("Handle command3")
                            else -> println("Unknown command")
                        }
                    } else {
                        println("Socket is not initialized or has been closed.")
                        break
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun close() {
        if (socket != null && !socket!!.isClosed) {
            try {
                socket!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            println("Socket is not initialized or has been closed.")
        }
    }
}
