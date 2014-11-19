/**
 * Place.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public class Place  implements java.io.Serializable {
    private java.lang.String address;

    private java.lang.String phone;

    private int placeid;

    private java.lang.String placename;

    private int review;

    public Place() {
    }

    public Place(
           java.lang.String address,
           java.lang.String phone,
           int placeid,
           java.lang.String placename,
           int review) {
           this.address = address;
           this.phone = phone;
           this.placeid = placeid;
           this.placename = placename;
           this.review = review;
    }


    /**
     * Gets the address value for this Place.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this Place.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the phone value for this Place.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this Place.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the placeid value for this Place.
     * 
     * @return placeid
     */
    public int getPlaceid() {
        return placeid;
    }


    /**
     * Sets the placeid value for this Place.
     * 
     * @param placeid
     */
    public void setPlaceid(int placeid) {
        this.placeid = placeid;
    }


    /**
     * Gets the placename value for this Place.
     * 
     * @return placename
     */
    public java.lang.String getPlacename() {
        return placename;
    }


    /**
     * Sets the placename value for this Place.
     * 
     * @param placename
     */
    public void setPlacename(java.lang.String placename) {
        this.placename = placename;
    }


    /**
     * Gets the review value for this Place.
     * 
     * @return review
     */
    public int getReview() {
        return review;
    }


    /**
     * Sets the review value for this Place.
     * 
     * @param review
     */
    public void setReview(int review) {
        this.review = review;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Place)) return false;
        Place other = (Place) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            this.placeid == other.getPlaceid() &&
            ((this.placename==null && other.getPlacename()==null) || 
             (this.placename!=null &&
              this.placename.equals(other.getPlacename()))) &&
            this.review == other.getReview();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        _hashCode += getPlaceid();
        if (getPlacename() != null) {
            _hashCode += getPlacename().hashCode();
        }
        _hashCode += getReview();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Place.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Connection", "Place"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("placeid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "placeid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("placename");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "placename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("review");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "review"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
