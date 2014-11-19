/**
 * Review.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public class Review  implements java.io.Serializable {
    private java.lang.String address;

    private java.lang.String comment;

    private int placeid;

    private java.lang.String placename;

    private int review;

    private int reviewid;

    private int userid;

    public Review() {
    }

    public Review(
           java.lang.String address,
           java.lang.String comment,
           int placeid,
           java.lang.String placename,
           int review,
           int reviewid,
           int userid) {
           this.address = address;
           this.comment = comment;
           this.placeid = placeid;
           this.placename = placename;
           this.review = review;
           this.reviewid = reviewid;
           this.userid = userid;
    }


    /**
     * Gets the address value for this Review.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this Review.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the comment value for this Review.
     * 
     * @return comment
     */
    public java.lang.String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this Review.
     * 
     * @param comment
     */
    public void setComment(java.lang.String comment) {
        this.comment = comment;
    }


    /**
     * Gets the placeid value for this Review.
     * 
     * @return placeid
     */
    public int getPlaceid() {
        return placeid;
    }


    /**
     * Sets the placeid value for this Review.
     * 
     * @param placeid
     */
    public void setPlaceid(int placeid) {
        this.placeid = placeid;
    }


    /**
     * Gets the placename value for this Review.
     * 
     * @return placename
     */
    public java.lang.String getPlacename() {
        return placename;
    }


    /**
     * Sets the placename value for this Review.
     * 
     * @param placename
     */
    public void setPlacename(java.lang.String placename) {
        this.placename = placename;
    }


    /**
     * Gets the review value for this Review.
     * 
     * @return review
     */
    public int getReview() {
        return review;
    }


    /**
     * Sets the review value for this Review.
     * 
     * @param review
     */
    public void setReview(int review) {
        this.review = review;
    }


    /**
     * Gets the reviewid value for this Review.
     * 
     * @return reviewid
     */
    public int getReviewid() {
        return reviewid;
    }


    /**
     * Sets the reviewid value for this Review.
     * 
     * @param reviewid
     */
    public void setReviewid(int reviewid) {
        this.reviewid = reviewid;
    }


    /**
     * Gets the userid value for this Review.
     * 
     * @return userid
     */
    public int getUserid() {
        return userid;
    }


    /**
     * Sets the userid value for this Review.
     * 
     * @param userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Review)) return false;
        Review other = (Review) obj;
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
            ((this.comment==null && other.getComment()==null) || 
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
            this.placeid == other.getPlaceid() &&
            ((this.placename==null && other.getPlacename()==null) || 
             (this.placename!=null &&
              this.placename.equals(other.getPlacename()))) &&
            this.review == other.getReview() &&
            this.reviewid == other.getReviewid() &&
            this.userid == other.getUserid();
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
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        _hashCode += getPlaceid();
        if (getPlacename() != null) {
            _hashCode += getPlacename().hashCode();
        }
        _hashCode += getReview();
        _hashCode += getReviewid();
        _hashCode += getUserid();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Review.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Connection", "Review"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "comment"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reviewid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "reviewid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "userid"));
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
