/**
 *    Copyright 2009-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Wraps a database connection.
 * Handles the connection lifecycle that comprises: its creation, preparation, commit/rollback and close.
 * MyBatis 对数据库中的事务进行了抽象，其自身提供了相应的事务接口和简单实现。
 *
 * 在很多场景中，MyBatis 会与 Spring 框架集成，并由 Spring 框架管理事务。
 *
 * @author Clinton Begin
 */
public interface Transaction {

  /**
   * Retrieve inner database connection
   * @return DataBase connection
   * @throws SQLException
   */
  Connection getConnection() throws SQLException;

  /**
   * Commit inner database connection.
   * @throws SQLException
   */
  void commit() throws SQLException;

  /**
   * Rollback inner database connection.
   * @throws SQLException
   */
  void rollback() throws SQLException;

  /**
   * Close inner database connection.
   * @throws SQLException
   */
  void close() throws SQLException;

  /**
   * Get transaction timeout if set
   * @throws SQLException
   */
  Integer getTimeout() throws SQLException;
  
}
