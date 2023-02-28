package cn.edu.guet.waste_recycling.mapper;

import cn.edu.guet.waste_recycling.bean.OrderDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HHS
 */
@Mapper
public interface IDetailsMapper {
    long findId(@Param(value = "orderId") long orderId, @Param(value = "goodsId") long goodsId);

    boolean insertDetail(OrderDetails orderDetails);// 插入详情记录并返回其id
    boolean updateGoodsWeight(@Param(value = "id") long id, @Param(value = "weight") double weight);
    boolean updateGoodsPrice(@Param(value = "id") long id,@Param(value = "ifPrice") double ifPrice);
}
