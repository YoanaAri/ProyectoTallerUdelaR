
package service;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtProveedor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtProveedor">
 *   <complexContent>
 *     <extension base="{http://Service/}dtUsuario">
 *       <sequence>
 *         <element name="descripcionGeneral" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="link" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="actividades" type="{http://Service/}dataActividad" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtProveedor", propOrder = {
    "descripcionGeneral",
    "link",
    "actividades"
})
public class DtProveedor
    extends DtUsuario
{

    protected String descripcionGeneral;
    protected String link;
    @XmlElement(nillable = true)
    protected List<DataActividad> actividades;

    /**
     * Obtiene el valor de la propiedad descripcionGeneral.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    /**
     * Define el valor de la propiedad descripcionGeneral.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionGeneral(String value) {
        this.descripcionGeneral = value;
    }

    /**
     * Obtiene el valor de la propiedad link.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLink() {
        return link;
    }

    /**
     * Define el valor de la propiedad link.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLink(String value) {
        this.link = value;
    }

    /**
     * Gets the value of the actividades property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the actividades property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividades().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataActividad }
     * 
     * 
     * @return
     *     The value of the actividades property.
     */
    public List<DataActividad> getActividades() {
        if (actividades == null) {
            actividades = new ArrayList<>();
        }
        return this.actividades;
    }

}
