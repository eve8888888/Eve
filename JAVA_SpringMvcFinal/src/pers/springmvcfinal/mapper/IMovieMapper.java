package pers.springmvcfinal.mapper;

import org.apache.ibatis.annotations.Param;
import pers.springmvcfinal.entity.Movie;
import pers.springmvcfinal.entity.Type;

import java.util.List;

/**
 * @Author: Eve
 * @Date: 2019/1/4 15:44
 * @Version 1.0
 */
public interface IMovieMapper {
    /**
     * 查询所有电影
     * @return list
     */
    List<Movie> findAll();

    /**
     * 查询所有电影类型,从类型表中查找
     * @return list
     */
    List<Type> findAllType();

    /**
     * 根据电影类型查询
     * @param movieType
     * @return list
     */
    List<Movie> findAllMoviesByType(String movieType);

    /**
     * 根据电影价格名字描述查询
     * @param name
     * @param desc
     * @param min
     * @param max
     * @return list
     */
    List<Movie> findMoviesByLikeNameOrDescOrPrice(
            @Param("name") String name,
            @Param("desc") String desc,
            @Param("min") Double min,
            @Param("max") Double max);

    /**
     *
     * @param name
     * @param desc
     * @param pricemin
     * @param pricemax
     * @return
     */
    List<Movie> findMoviesByLike(
            @Param("name") String name,
            @Param("desc") String desc,
            @Param("pricemin") Double pricemin,
            @Param("pricemax") Double pricemax);
}
