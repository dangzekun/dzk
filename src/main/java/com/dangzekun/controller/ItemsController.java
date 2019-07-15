package com.dangzekun.controller;

import com.dangzekun.dao.ItemsRepository;
import com.dangzekun.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ItemsController {
    @Autowired
    private ItemsRepository itemsRepository;
    //查全部
    @RequestMapping("show")
    public String show(Model model, String name,String detail) {
        Items items = new Items();
        items.setName(name);
        System.out.println("获取到的值:" + name);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact());
        Example<Items> of = Example.of(items, exampleMatcher);
        List<Items> all = itemsRepository.findAll(of);
        model.addAttribute("all", all);
        List<Items> likeByDetail = itemsRepository.findByDetailLike("%"+detail+"%");
        System.out.println(likeByDetail);
        model.addAttribute("likeByDetail",likeByDetail);
        return "show";
    }
//新增
//新增页面
@RequestMapping("add")
public String add() {
    return "regirect";
}
    //新增方法 insertUser
    @RequestMapping("insertUser")
    public String insertUser(Items items) {
        System.out.println(items+"qweee");
        itemsRepository.save(items);
        System.out.println(items);
        return "redirect:show" ;
    }

    //删除
    @RequestMapping("/deleteItems")
    public  String deleteUser(Integer id){
        itemsRepository.deleteById(id);
        return "redirect:show";
    }
    //查询一个 根据id
    @RequestMapping( "/loadById")
    public String loadById(Integer id,Model model){
        Optional<Items> byId = itemsRepository.findById(id);
        if (byId.isPresent()) {
            Items items= byId.get();
            model.addAttribute("items",items);
        }
        return "update_items";
    }
    //修改表单
    @RequestMapping("updateOne")
    public String updateOne(Items items){
        Items save = itemsRepository.save(items);
        return save!=null?"redirect:show":"error";
    }

}
