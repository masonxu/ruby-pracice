package com.augmentum.training.ioc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

import com.augmentum.training.utils.Const;
import com.augmentum.training.utils.XmlUtils;

/**
 * The ContextXmlLoader implements the interface : {@link #BeanFactory} .
 * You can get the beans in configuration file via {@link #getBean(String)}.
 * @author mason.xu
 * @version 1.0 2011/03/18
 *
 */
public class ContextXmlLoader implements BeanFactory {
	private Map<String,Object> beans = new HashMap<String, Object>() ;
	
	@Override
	public Object getBean(String name) {
		return beans.get(name);
	}
	
	/**
	 * Parse the configuration of Spring.xml. Then generate the beans,
	 * and put them into the bean's map in order to get the instance of 
	 * the bean via {@link #getBean(String)}.
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public  ContextXmlLoader() throws InstantiationException, IllegalAccessException,
						ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException 	{
		
		Document document = (Document) XmlUtils.readXml();
		Element root = document.getRootElement();
		List<Element> list = root.elements();
		
		for(Element element : list) {
			String id = element.attributeValue(Const.ID_KEY_WORD);
			String clazz = element.attributeValue(Const.CLASS_KEY_WORD);
			
			Object o = Class.forName(clazz).newInstance();
			beans.put(id, o);
			
			List<Element> propertyList = element.elements();
			for (Element property : propertyList) {
				String name = property.attributeValue(Const.NAME_KEY_WORD);
				String methodName = Const.SET_KEY_WORD + name.substring(0, 1).toUpperCase() + name.substring(1);
				String ref = property.attributeValue(Const.REF_KEY_WORD);
				Object obj = beans.get(ref);
				
				Method m = o.getClass().getMethod(methodName,
									obj.getClass().getInterfaces()[0]);
				m.invoke(o, obj);
			}
		}
	}
}
