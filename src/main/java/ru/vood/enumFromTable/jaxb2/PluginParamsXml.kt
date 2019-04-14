package ru.vood.enumFromTable.jaxb2

import ru.vood.enumFromTable.generated.pramFromXSD.PluginTines
import java.io.StringReader
import java.io.StringWriter
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Marshaller

class PluginParamsXml(var jaxbContext: JAXBContext = JAXBContext.newInstance(PluginTines::class.java)) {

    fun objToXml(request: PluginTines): String {
        return jaxbElementToXml(request)
    }

    fun xmlToObj(xml: String): PluginTines {
        val unmarshaller = jaxbContext.createUnmarshaller()
        val sr = StringReader(xml)
        return unmarshaller.unmarshal(sr) as PluginTines
    }

    private fun jaxbElementToXml(jaxbElement: Any): String {
        try {
            val sw = StringWriter()
            val marshaller: Marshaller = jaxbContext.createMarshaller()
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
            marshaller.marshal(jaxbElement, sw)
            return sw.toString()
        } catch (e: JAXBException) {
            throw XmlLoadException(e)
        }

    }
}