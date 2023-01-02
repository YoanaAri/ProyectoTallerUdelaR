
package service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para salidaTuristica complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="salidaTuristica">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="salida" type="{http://Service/}dtInfo" minOccurs="0"/>
 *         <element name="cupos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="fechaAlta" type="{http://Service/}localDateTime" minOccurs="0"/>
 *         <element name="fechaAltaString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="cuposRestantes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "salidaTuristica", propOrder = {
    "nombre",
    "salida",
    "cupos",
    "fechaAlta",
    "fechaAltaString",
    "cuposRestantes"
})
public class SalidaTuristica {

    protected String nombre;
    protected DtInfo salida;
    protected int cupos;
    protected LocalDateTime fechaAlta;
    protected String fechaAltaString;
    protected int cuposRestantes;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad salida.
     * 
     * @return
     *     possible object is
     *     {@link DtInfo }
     *     
     */
    public DtInfo getSalida() {
        return salida;
    }

    /**
     * Define el valor de la propiedad salida.
     * 
     * @param value
     *     allowed object is
     *     {@link DtInfo }
     *     
     */
    public void setSalida(DtInfo value) {
        this.salida = value;
    }

    /**
     * Obtiene el valor de la propiedad cupos.
     * 
     */
    public int getCupos() {
        return cupos;
    }

    /**
     * Define el valor de la propiedad cupos.
     * 
     */
    public void setCupos(int value) {
        this.cupos = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAlta.
     * 
     * @return
     *     possible object is
     *     {@link LocalDateTime }
     *     
     */
    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Define el valor de la propiedad fechaAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDateTime }
     *     
     */
    public void setFechaAlta(LocalDateTime value) {
        this.fechaAlta = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAltaString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaAltaString() {
        return fechaAltaString;
    }

    /**
     * Define el valor de la propiedad fechaAltaString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaAltaString(String value) {
        this.fechaAltaString = value;
    }

    /**
     * Obtiene el valor de la propiedad cuposRestantes.
     * 
     */
    public int getCuposRestantes() {
        return cuposRestantes;
    }

    /**
     * Define el valor de la propiedad cuposRestantes.
     * 
     */
    public void setCuposRestantes(int value) {
        this.cuposRestantes = value;
    }

}
