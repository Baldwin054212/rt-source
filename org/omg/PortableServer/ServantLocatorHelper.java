package org.omg.PortableServer;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;

public abstract class ServantLocatorHelper {
  private static String _id = "IDL:omg.org/PortableServer/ServantLocator:1.0";
  
  private static TypeCode __typeCode = null;
  
  public static void insert(Any paramAny, ServantLocator paramServantLocator) {
    OutputStream outputStream = paramAny.create_output_stream();
    paramAny.type(type());
    write(outputStream, paramServantLocator);
    paramAny.read_value(outputStream.create_input_stream(), type());
  }
  
  public static ServantLocator extract(Any paramAny) { return read(paramAny.create_input_stream()); }
  
  public static TypeCode type() {
    if (__typeCode == null)
      __typeCode = ORB.init().create_interface_tc(id(), "ServantLocator"); 
    return __typeCode;
  }
  
  public static String id() { return _id; }
  
  public static ServantLocator read(InputStream paramInputStream) { throw new MARSHAL(); }
  
  public static void write(OutputStream paramOutputStream, ServantLocator paramServantLocator) { throw new MARSHAL(); }
  
  public static ServantLocator narrow(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof ServantLocator)
      return (ServantLocator)paramObject; 
    if (!paramObject._is_a(id()))
      throw new BAD_PARAM(); 
    Delegate delegate = ((ObjectImpl)paramObject)._get_delegate();
    _ServantLocatorStub _ServantLocatorStub = new _ServantLocatorStub();
    _ServantLocatorStub._set_delegate(delegate);
    return _ServantLocatorStub;
  }
  
  public static ServantLocator unchecked_narrow(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof ServantLocator)
      return (ServantLocator)paramObject; 
    Delegate delegate = ((ObjectImpl)paramObject)._get_delegate();
    _ServantLocatorStub _ServantLocatorStub = new _ServantLocatorStub();
    _ServantLocatorStub._set_delegate(delegate);
    return _ServantLocatorStub;
  }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\org\omg\PortableServer\ServantLocatorHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */