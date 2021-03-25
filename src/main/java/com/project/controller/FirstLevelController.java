package com.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.project.entity.*;
import com.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/FirstLevel")
public class FirstLevelController {
    @Autowired
    private IFirstLevelService firstLevelService;

    @Autowired
    private ISecondLevelService secondLevelService;

    @Autowired
    private IItemService iItemService;

    @Autowired
    private IStandardItemService standardItemService;

    @GetMapping("/findFirstLevel")
    public List<JSONObject> findFirstLevel(){
        return firstLevelService.findFirstLevel();
    }

    //从first开始的三层嵌套 传入模板id  选定模板后加载模板内容时调用
    /*@GetMapping("/findThree1")
    public List<FirstLevel> findThree1(@RequestParam("template_id") Integer id){
        return firstLevelService.findThree(id);
    }*/
    @GetMapping("/findThree")
    public Object findThree(@RequestParam("template_id") Integer id){
        List<FirstLevel> items = firstLevelService.findThree(id);
        List<JSONObject> resultList = new LinkedList<>();
        List<JSONObject> res2 = new LinkedList<>();
        JSONObject res = new JSONObject();
        for(FirstLevel item : items){
            JSONObject tempobj = new JSONObject();
            tempobj.put("id", item.getId());
            tempobj.put("name", item.getName());
            List<SecondLevel> secondLevels = item.getSecondLevels();
            List<JSONObject> secondChildren = new LinkedList<>();
            for (SecondLevel secondLevel: secondLevels) {
                JSONObject tempobj2 = new JSONObject();
                tempobj2.put("id",secondLevel.getId());
                tempobj2.put("name",secondLevel.getName());
                List<Item> items1 = secondLevel.getItems();
                List<JSONObject> thirdChildren = new LinkedList<>();
                for (Item item3:items1) {
                    JSONObject tempobj3 = new JSONObject();
                    tempobj3.put("id",item3.getId());
                    tempobj3.put("name",item3.getShort_cut());
                    thirdChildren.add(tempobj3);
                }
                tempobj2.put("children",thirdChildren);
                secondChildren.add(tempobj2);
            }
            tempobj.put("children", secondChildren);
            resultList.add(tempobj);
        }
        res.put("id",id);
        res.put("name","模板"+id);
        res.put("children",resultList);
        res2.add(res);
        return res2;
        //return firstLevelService.findThree(id);
    }

    //从first开始的三层嵌套 传入standard_id 展示添加完标准项之后的内容   添加完标准项后回到步骤3界面时调用
    @GetMapping("/findThreeByStandard")
    public Object findThreeByStandard(@RequestParam("standard_id") Integer id){
        List<FirstLevel> items = firstLevelService.findThreeByStandard(id);
        List<JSONObject> resultList = new LinkedList<>();
        for(FirstLevel item : items){
            JSONObject tempobj = new JSONObject();
            tempobj.put("id", item.getId());
            tempobj.put("name", item.getName());
            List<SecondLevel> secondLevels = item.getSecondLevels();
            List<JSONObject> secondChildren = new LinkedList<>();
            for (SecondLevel secondLevel: secondLevels) {
                JSONObject tempobj2 = new JSONObject();
                tempobj2.put("id",secondLevel.getId());
                tempobj2.put("name",secondLevel.getName());
                List<Item> items1 = secondLevel.getItems();
                List<JSONObject> thirdChildren = new LinkedList<>();
                for (Item item3:items1) {
                    JSONObject tempobj3 = new JSONObject();
                    tempobj3.put("id",item3.getId());
                    tempobj3.put("name",item3.getShort_cut());
                    tempobj2.put("children",null);
                    thirdChildren.add(tempobj3);
                }
                tempobj2.put("children",thirdChildren);
                secondChildren.add(tempobj2);
            }
            tempobj.put("children", secondChildren);
            resultList.add(tempobj);
        }
/*        res.put("id",id);
        res.put("name","模板"+id);
        res.put("children",resultList);
        res2.add(res);*/
        return resultList;
    }

    //查找库中所有item 添加标准项界面加载时调用  格式为从item开始的三层嵌套  不关联设备的item也会携带设备信息，展示时需要对property_related做判断
    @GetMapping("/findItems")
    public Object findItems(){
        List<Item> items = firstLevelService.findItems();
        List<Item> items2 = iItemService.findItemWithoutEquip();
        List<JSONObject> resultList = new LinkedList<>();
        for(Item item : items){
            JSONObject tempobj = new JSONObject();
            tempobj.put("id", item.getFirst_level_id());
            tempobj.put("idII", item.getSecond_level_id());
            tempobj.put("item_id", item.getId());
            tempobj.put("detail", item.getShort_cut());
            tempobj.put("property_related", item.getProperty_related());
            List<Equipment> equipmentList =  item.getEquipmentList();
            String equipstring = "";
            for(Equipment e : equipmentList){
                equipstring = equipstring+e.getEquip_name()+" ";
            }

            tempobj.put("equ", equipstring);

            resultList.add(tempobj);
        }
        for(Item item : items2){
            JSONObject tempobj = new JSONObject();
            tempobj.put("id", item.getFirst_level_id());
            tempobj.put("idII", item.getSecond_level_id());
            tempobj.put("item_id", item.getId());
            tempobj.put("detail", item.getShort_cut());
            tempobj.put("property_related", item.getProperty_related());
            String equipstring = "";
            tempobj.put("equ", equipstring);

            resultList.add(tempobj);
        }
        return resultList;
        //return firstLevelService.findItems();
    }

    //查找某一item(包含equipment)下的设备信息 传入item_id和standard_id  每次确认 输入的设备属性值后调用 刷新下面的展示列表
    @GetMapping("/findItemEquip")
    public List<JSONObject> findItemEquip(@RequestParam("item_id") Integer item_id,@RequestParam("standard_id") Integer standard_id){
        List<JSONObject> equips = firstLevelService.findItemEquip(item_id,standard_id);
        List<JSONObject> resultList = new LinkedList<>();
        for(JSONObject obj : equips){
            JSONObject tempobj = new JSONObject();
            tempobj.put("id", obj.getIntValue("item_id"));
            tempobj.put("equ", obj.getString("equip_name"));
            tempobj.put("pro", obj.getString("name"));
            tempobj.put("type", obj.getBooleanValue("property_type"));
            if(obj.getBooleanValue("property_type")==true){ //是范围值，合成一个显示
                String s = "";
                s = s+Integer.toString(obj.getInteger("value_1"))+"-";
                s = s+Integer.toString(obj.getInteger("value_2"));
                tempobj.put("nvalue", s);
            }else{
                tempobj.put("nvalue", obj.getInteger("value_1"));
            }
            tempobj.put("state", obj.getBooleanValue("required"));
            resultList.add(tempobj);
        }
        return resultList;
        //return firstLevelService.findItemEquip(item_id,standard_id);
    }

    //查找一个标准的具体信息 新建标准的最后 和详情页 展示时调用
    @GetMapping("/findStandardInfo")
    public List<JSONObject> findStandardInfo(@RequestParam("standard_id") Integer standard_id){
        return firstLevelService.findStandardInfo(standard_id);
    }


    //从first开始的三层嵌套 传入standard_id 展示内容   新建标准的最后 和详情页 展示时调用
    @GetMapping("/findThreeByStandardId")
    public Object findThreeByStandardId(@RequestParam("standard_id") Integer id){
        List<FirstLevel> items = firstLevelService.findThreeByStandard(id);
        List<JSONObject> resultList = new LinkedList<>();
        List<JSONObject> res2 = new LinkedList<>();
        JSONObject res = new JSONObject();
        for(FirstLevel item : items){
            JSONObject tempobj = new JSONObject();
            tempobj.put("id", item.getId());
            tempobj.put("name", item.getName());
            tempobj.put("detail","");
            tempobj.put("state",true);
            tempobj.put("equstate","");
            List<SecondLevel> secondLevels = item.getSecondLevels();
            List<JSONObject> secondChildren = new LinkedList<>();
            for (SecondLevel secondLevel: secondLevels) {
                JSONObject tempobj2 = new JSONObject();
                tempobj2.put("id",secondLevel.getId());
                tempobj2.put("name",secondLevel.getName());
                tempobj2.put("detail","");
                tempobj2.put("state",true);
                tempobj2.put("equstate","");
                List<Item> items1 = secondLevel.getItems();
                List<JSONObject> thirdChildren = new LinkedList<>();
                for (Item item3:items1) {
                    JSONObject tempobj3 = new JSONObject();
                    tempobj3.put("id",item3.getId());
                    tempobj3.put("name","");
                    tempobj3.put("detail",item3.getShort_cut());
                    List<StandardItem> requiredList = standardItemService.findRequired(id,item3.getId());
                    System.out.println(id+item3.getId()+" "+requiredList.get(0).getRequired());
                    if(requiredList.get(0).getRequired()!=null)
                        tempobj3.put("state",requiredList.get(0).getRequired());   //item状态（可选必选）暂时没查到(已解决)
                    tempobj3.put("equstate",item3.getProperty_related());
                    thirdChildren.add(tempobj3);
                }
                tempobj2.put("children",thirdChildren);
                secondChildren.add(tempobj2);
            }
            tempobj.put("children", secondChildren);
            resultList.add(tempobj);
        }
        res.put("id",id);
        res.put("name","");
        res.put("detail","");
        res.put("state",true);
        res.put("equstate","");
        res.put("children",resultList);
        res2.add(res);
        return res2;
    }

    //查找某一standard下的设备信息 传入standard_id 新建标准的最后 和详情页 展示时调用
    @GetMapping("/findEquipInfo")
    public List<JSONObject> findEquipInfo(@RequestParam("standard_id") Integer standard_id){
        return firstLevelService.findEquipInfo(standard_id);
    }

    @GetMapping("/findAll")
    public List<FirstLevel> findAll(){
        return firstLevelService.findAll();
    }

    //查询一二级分类列表
    @GetMapping("/list")
    public List<FirstLevel> findAllLevels(){
        List<FirstLevel> fList = firstLevelService.findAll();
        for(FirstLevel fl:fList){
            fl.setFirst_level_id(0);
            fl.setChildren(secondLevelService.selectByFirstLevel(fl.getId()));
        }
        return fList;
    }

    @PostMapping("/insert")
    public int insert(@RequestBody FirstLevel firstLevel){
        System.out.println("传参" + firstLevel);
        return firstLevelService.insert(firstLevel);
    }

    @PostMapping("/edit")
    public int edit(@RequestBody FirstLevel firstLevel){
        return firstLevelService.update(firstLevel);
    }

    @GetMapping("/delete")
    public int delete(@RequestParam("id")String idp){
        int id = Integer.parseInt(idp);
        secondLevelService.deleteByFirstLevel(id);
        return firstLevelService.delete(id);
    }

}
