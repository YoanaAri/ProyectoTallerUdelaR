
package service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtInscripcion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtInscripcion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cantidadInscriptos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="fechaInscripcion" type="{http://Service/}localDateTime" minOccurs="0"/>
 *         <element name="fechaInscripcionString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="salidaTuristica" type="{http://Service/}dtSalida" minOccurs="0"/>
 *         <element name="costo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtInscripcion", propOrder = {
    "cantidadInscriptos",
    "fechaInscripcion",
    "fechaInscripcionString",
    "salidaTuristica",
    "costo"
})
public class DtInscripcion {

    protected int cantidadInscriptos;
    protected LocalDateTime fechaInscripcion;
    protected String fechaInscripcionString;
    protected DtSalida salidaTuristica;
    protected int costo;

    /**
     * Obtiene el valor de la propiedad cantidadInscriptos.
     * 
     */
    public int getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    /**
     * Define el valor de la propiedad cantidadInscriptos.
     * 
     */
    public void setCantidadInscriptos(int value) {
        this.cantidadInscriptos = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInscripcion.
     * 
     * @return
     *     possible object is
     *     {@link LocalDateTime }
     *     
     */
    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Define el valor de la propiedad fechaInscripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDateTime }
     *     
     */
    public void setFechaInscripcion(LocalDateTime value) {
        this.fechaInscripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInscripcionString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInscripcionString() {
        return fechaInscripcionString;
    }

    /**
     * Define el valor de la propiedad fechaInscripcionString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInscripcionString(String value) {
        this.fechaInscripcionString = value;
    }

    /**
     * Obtiene el valor de la propiedad salidaTuristica.
     * 
     * @return
     *     possible object is
     *     {@link DtSalida }
     *     
     */
    public DtSalida getSalidaTuristica() {
        return salidaTuristica;
    }

    /**
     * Define el valor de la propiedad salidaTuristica.
     * 
     * @param value
     *     allowed object is
     *     {@link DtSalida }
     *     
     */
    public void setSalidaTuristica(DtSalida value) {
        this.salidaTuristica = value;
    }

    /**
     * Obtiene el valor de la propiedad costo.
     * 
     */
    public int getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     */
    public void setCosto(int value) {
        this.costo = value;
    }

}
