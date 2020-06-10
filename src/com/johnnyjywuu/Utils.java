package com.johnnyjywuu;

import com.johnnyjywuu.model.ListNode;
import com.johnnyjywuu.model.TreeNode;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * @author Created by Johnny Wu on 2019/8/27.
 * @title
 * @link
 * @description
 */

public class Utils {
    /**
     * 构建单向链表 ListNode
     * @param nodeVals
     * @return ListNode head
     */
    public static ListNode buildListNode(int[] nodeVals) {
        if (nodeVals == null || nodeVals.length <= 0) {
            System.err.println("buildListNode: invalid nodeVals");
            return new ListNode(0);
        }

        ListNode preHead = new ListNode(0);
        ListNode buildNode = preHead;
        for (Integer val : nodeVals) {
            buildNode.next = new ListNode(val);
            buildNode = buildNode.next;
        }

        return preHead.next;
    }

    /**
     * 构建二叉树 TreeNode
     * @param nodeVals
     * @return TreeNode root
     */
    public static TreeNode buildTreeNode(Integer[] nodeVals) {
        if (nodeVals == null || nodeVals.length <= 0) {
            System.err.println("buildTreeNode: invalid nodeVals");
            return new TreeNode(0);
        }

        return buildTreeNode(nodeVals, 0);
    }
    private static TreeNode buildTreeNode(Integer[] nodeVals, int index) {
        if (index >= nodeVals.length || nodeVals[index] == null) return null;

        TreeNode node = new TreeNode(nodeVals[index]);
        node.left = buildTreeNode(nodeVals, index * 2 + 1); //结点左子树在数组中的位置 index * 2 + 1
        node.right = buildTreeNode(nodeVals, index * 2 + 2); //结点右子树在数组中的位置 index * 2 + 2

        return node;
    }

    //字符串替换
    public static String test = "<![CDATA[http://mmg.aty.sohu.com/goto?du=3600&__DOWN_X__=downx&__DOWN_Y__=down3&__UP_X__=do14&__UP_Y__=downx&adtime=75&trule=37984&mx=5&al=8327823&vid=2076963&tvid=1456879&rt=bb2905adcd40ebbc9364a7801c1083f1&spead=0&uv=868425042129155&uuid=5ad7f81f-50d8-4d5a-b3eb-ed76d8c430301575013231298&UUID=5ad7f81f-50d8-4d5a-b3eb-ed76d8c430301575013231298&crid=581&ar=6&sign=jPM7ROXollnWqjOjNvojTwC5ynVd8Yhp8vnLCjzqP2c40prDYmGhQC1Y9dpphNP8s-dtW7J81CU.&rip=123.126.70.237&sip=10.18.38.47&fip=123.126.70.237&plat=6&sver=7.8.0&partner=93&poid=1&pn=HLK-AL00&sysver=28&adplat=3&source=1000010000&wt=wifi&v1=1048&v1code=101&v2code=101147&prot=vast&protv=3.0&playstyle=1&build=7008000&appid=tv&adoriginal=sohu&sdkVersion=tv7.6.00-1210-jy-SNAPSHOT&offline=0&density=3.0&displayMetrics=1080*2340&datatype=2&bssid=02:00:00:00:00:00&ssid=%3Cunknown+ssid%3E&bt=20191129&endtime=20191231&ad=51667&b=411074&bk=107930837&pagetype=1&suid=868425042129155&mac=88:F8:72:84:94:F9&imei=868425042129155&AndroidID=d784c9a2dcf631d3&islocaltv=0&manufacturer=HUAWEI&guid=e7aaa1f361645f62be57e801011da04a&imsi=460078114863612&seq=1&cheattype=8227&sperotime=1575013231&tuv=e10b9978a1bc67bb09b36cebc196470c&site=1&template=normal,null&platsource=tv&indexip=10.18.38.47:60111&channeled=1000010000%7C1938&vu=0&vc=101142;101147;101148&err=[ERRORCODE]&at=15&c=1&v1=1048&p=oad1&loc=Unknown&adstyle=oad&ac=5185&ad=51667&pt=12265&b=411074&bk=107930837&pagetype=1&spead=0&encrysig=lVUqoJj2mcCfN2P2uEgsCfZjCrv5P-yn24E2ySXN8o8dAY6v&__DOWN_X__=downx]]>";

    public static void replace(List<String> list) {
        for (int i = 0; i < list.size(); i ++) {
            list.set(i, replaceAccessToken(list.get(i), "__DOWN_X__", "" + 720));
        }
    }

    public static String replace(String str) {
        return replaceAccessTokenReg(str, "__DOWN_X__", "" + 720);
    }

    /**
     * java解析代码
     *
     * @param url
     * @param name
     * @param accessToken
     * @return
     */
    public static String replaceAccessToken(String url, String name, String accessToken) {
//        if (StringUtils.isNotBlank(url) && StringUtils.isNotBlank(accessToken)) {
        int index = url.indexOf(name + "=");
        if (index != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(url.substring(0, index)).append(name + "=").append(accessToken);
            int idx = url.indexOf("&", index);
            if (idx != -1) {
                sb.append(url.substring(idx));
            }
            url = sb.toString();
        }
//        }
        return url;
    }
    /**
     * 正则替换
     * @param url
     * @param name
     * @param accessToken
     * @return
     */
    public static String replaceAccessTokenReg(String url, String name, String accessToken) {
//        if (StringUtils.isNotBlank(url) && StringUtils.isNotBlank(accessToken)) {
        url = url.replaceAll("(" + name + "=[^&]*)", name + "=" + accessToken);
//        }
        return url;
    }
}
