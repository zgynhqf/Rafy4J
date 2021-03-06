package com.github.zgynhqf.rafy4j.metadata;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体元数据。
 *
 * @author: huqingfang
 * @date: 2018-12-30 19:17
 **/
public class EntityMeta {
    private Class<?> type;
    private String tableName;
    /**
     * 是否映射所有的字段到列。
     */
    private boolean mapAllFieldsToColumn = true;
    private List<EntityFieldMeta> fields = new ArrayList<>();

    public EntityMeta(Class<?> type) {
        this.type = type;
    }

    /**
     * 返回是否映射到数据库表。
     *
     * @return
     */
    public boolean isMappingTable() {
        return !StringUtils.isBlank(tableName);
    }

    /**
     * 找到字段名对应的元数据。
     *
     * @param fieldName
     * @return
     */
    public EntityFieldMeta getField(String fieldName) {
        for (int i = 0; i < fields.size(); i++) {
            EntityFieldMeta entityFieldMeta = fields.get(i);
            if (entityFieldMeta.getName().equals(fieldName)) return entityFieldMeta;
        }
        return null;
    }

    //region gs
    public List<EntityFieldMeta> getFields() {
        return fields;
    }

    public Class<?> getType() {
        return type;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isMapAllFieldsToColumn() {
        return mapAllFieldsToColumn;
    }

    public void setMapAllFieldsToColumn(boolean mapAllFieldsToColumn) {
        this.mapAllFieldsToColumn = mapAllFieldsToColumn;
    }
    //endregion
}
