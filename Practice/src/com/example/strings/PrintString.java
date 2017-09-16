package com.example.strings;

public class PrintString {

	public static void main(String[] args) {

		String string = "{\"type\":\"N2NPaths\",\"source\":{\"type\":\"Org\",\"value\":63},\"target\":{\"type\":\"Org\",\"value\":157},\"requestedSourceId\":63,\"requestedTargetId\":157,"
				+ "\"paths\":[{\"source\":{\"type\":\"Org\",\"value\":63},\"target\":{\"type\":\"Org\",\"value\":157},\"length\":3,\"averageWeight\":125.0,\"pathNodes\":[{\"type\":\"Org\",\"value\":63},{\"type\":\"Person\",\"value\":6058038},{\"type\":\"Person\",\"value\":20141},{\"type\":\"Org\",\"value\":157}],\"connectionList\":[{\"source\":{\"type\":\"Org\",\"value\":63},\"target\":{\"type\":\"Person\",\"value\":6058038},\"weight\":156.0,\"links\":[{\"type\":\"SEC_O2P\",\"startDate\":946713600000,\"endDate\":1078992000000,\"roleType\":\"BOARD_MEMBER\",\"weight\":50.0,\"former\":true,\"neo\":false},{\"type\":\"SEC_O2P\",\"startDate\":1326096000000,\"endDate\":1483689600000,\"roleType\":\"BOARD_MEMBER\",\"weight\":60.0,\"former\":false,\"neo\":true},{\"type\":\"SEC_O2P\",\"startDate\":1142236800000,\"endDate\":1263283200000,\"roleType\":\"BOARD_MEMBER\",\"weight\":46.0,\"former\":true,\"neo\":false}]},{\"source\":{\"type\":\"Person\",\"value\":6058038},\"target\":{\"type\":\"Person\",\"value\":20141},\"weight\":42.0,\"links\":[{\"type\":\"SEC\",\"orgId\":5670,\"sourceOrgId\":5670,\"targetOrgId\":5670,\"startDate\":1080806400000,\"endDate\":1143792000000,\"weight\":23.0,\"former\":true,\"sourceRole\":\"BOARD_MEMBER\",\"targetRole\":\"BOARD_MEMBER\",\"show\":true},{\"type\":\"SEC\",\"orgId\":5670,\"sourceOrgId\":5670,\"targetOrgId\":5670,\"startDate\":1206428400000,\"endDate\":1255330800000,\"weight\":19.0,\"former\":true,\"sourceRole\":\"BOARD_MEMBER\",\"targetRole\":\"BOARD_MEMBER\",\"show\":true}]},{\"source\":{\"type\":\"Person\",\"value\":20141},\"target\":{\"type\":\"Org\",\"value\":157},\"weight\":177.0,\"links\":[{\"type\":\"SEC_O2P\",\"startDate\":1009872000000,\"endDate\":1477292400000,\"roleType\":\"BOARD_MEMBER\",\"weight\":177.0,\"former\":false,\"neo\":true}]}]}]}\n";
		
		String input = "\"paths\":[{";
		int index = string.indexOf(input);
		System.out.println(index);
		StringBuilder sb = new StringBuilder();
		if(index != -1 && !string.substring(index,index+10).contains("N2NPath")){
			sb.append(string.substring(0,index));
			sb.append(input);
			sb.append("\"type\":\"N2NPath\",");
			sb.append(string.substring(141,string.length()));
			System.out.println("sb "+sb.toString());
		}
		
		//System.out.println(sb.toString());
	}
	
}
