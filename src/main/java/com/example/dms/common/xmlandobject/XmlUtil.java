package com.example.dms.common.xmlandobject;

import com.example.dms.entity.DmsRole;
import com.example.dms.entity.DmsUser;
import com.example.dms.entity.User;
import com.thoughtworks.xstream.XStream;
import org.apache.poi.ss.formula.functions.T;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhouy
 * @date 2021/11/21
 * good 11
 */
public class XmlUtil {
    public static String toXml(Object valueType)  {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(valueType.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(valueType,stringWriter);
            return stringWriter.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    public static <T> T xmlToObject (String string ,T t){
        try {
            JAXBContext context = JAXBContext.newInstance(t.getClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return  (T) unmarshaller.unmarshal(new StringReader(string));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        User user = new User();
        user.setCityId(1);
        user.setCreateTime(new Date());
        user.setEmail("@qererere");
        user.setId(12L);
        user.setName("李氏");
        user.setPassword("受到了放进塑料袋");
        user.setPhone("1212312");
        DmsRole dmsRole = new DmsRole();
        dmsRole.setRoleCode("123123");
        dmsRole.setRoleId(12);
        List<DmsUser> dmsUserList = new ArrayList<>();
        DmsUser user1 = new DmsUser();
        user1.setUserName("1233124");
        user1.setBlogUrl("url.god");
        DmsUser user2 = new DmsUser();
        user2.setUserName("12567");
        user2.setBlogUrl("url.god");
        dmsUserList.add(user1);
        dmsUserList.add(user2);
        dmsRole.setDmsUsers(dmsUserList);
        user.setDmsRole(dmsRole);
        XStream xStream = new XStream();
        xStream.alias("user",User.class);
        xStream.alias("dmsUser",DmsUser.class);
        xStream.alias("dmsRole",DmsRole.class);
        String str = xStream.toXML(user);
        System.out.println(str);
        User ok  = (User)xStream.fromXML(str);
        System.out.println();
    }
}
