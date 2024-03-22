package com.webbh.dmBanhang.mapper.dbo;

import com.webbh.dmBanhang.Model.account;
import com.webbh.dmBanhang.Model.accountExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface accountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    long countByExample(accountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    int deleteByExample(accountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    int deleteByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    int insert(account row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    int insertSelective(account row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    List<account> selectByExample(accountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    account selectByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    int updateByExampleSelective(@Param("row") account row, @Param("example") accountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    int updateByExample(@Param("row") account row, @Param("example") accountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    int updateByPrimaryKeySelective(account row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dbo.Account
     *
     * @mbg.generated Thu Mar 21 00:34:52 ICT 2024
     */
    int updateByPrimaryKey(account row);
    account checkLogin(@Param("username") String username , @Param("pass") String pass);
    account checkuser(@Param("username") String username);
    int signup(@Param("username") String username , @Param("pass") String pass,@Param("repass") String repass, @Param("gmail") String gmail);
}