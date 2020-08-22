package com.luban.test;

import java.lang.ref.SoftReference;

public class ReferenceTest {
	public static void main(String[] args) {
		int count = 5;
		SoftReference[] softReferences = new SoftReference[count];

		for (int i =0;i<count;i++){
			softReferences[i] = new SoftReference<BigObj>(new BigObj("bigObj-" + i));
		}

		// 缂撳瓨涓竴鑸皢瀵硅薄鏀惧叆杞紩鐢ㄤ腑鐒跺悗璋冪敤,濡傛灉鍐呭瓨涓嶅鐢ㄤ細浼氱洿鎺ュ洖鏀惰蒋寮曠敤涓殑瀵硅薄
		for (int i=0;i<count;i++){
			Object o = softReferences[i].get();
			if (o==null){
				System.out.println("null");
			}else
				System.out.println(((BigObj)o).name);
		}
	}
}

// 瀹氫箟涓�涓ぇ瀵硅薄,鐩殑鏄鍐呭瓨婊�
class BigObj{
	public byte[] values;
	public String name;
	public BigObj(String name){
		this.name = name;
		values= new byte[1024];
	}
}
