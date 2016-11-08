package com.sistema.bd;

import com.sistema.bean.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControleQuestion {

    public String tabela = "Questions";

    public void delete(Question q) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection(tabela);
            String sql = "delete from questions where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, q.getCodigo());
            ps.execute();

            conn.commit();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public void insert(Question q) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection(tabela);
            String sql = "insert into questions (codigo, enunciado, a, b, c, d, resp) values(?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, q.getCodigo());
            ps.setString(2, q.getEnunciado());
            ps.setString(3, q.getA());
            ps.setString(4, q.getB());
            ps.setString(5, q.getC());
            ps.setString(6, q.getD());
            ps.setString(7, q.getResp());

            ps.execute();

            conn.commit();

        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public void update(Question q) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection(tabela);
            String sql = "update questions set enunciado = ? where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, q.getEnunciado());
            ps.setInt(2, q.getCodigo());
            ps.execute();

            conn.commit();
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public List<Question> getAll() {
        List<Question> lista = new ArrayList<Question>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection(tabela);
            String sql = "select codigo, enunciado from questions";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer codigo = rs.getInt(1);
                String enunciado = rs.getString(2);
                Question p = new Question();
                p.setCodigo(codigo);
                p.setEnunciado(enunciado);
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return lista;
    }

    public Question getQuestion(Integer codigo) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection(tabela);
            String sql = "select codigo, enunciado from questions where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Integer cod = rs.getInt(1);
                String enunciado = rs.getString(2);
                Question p = new Question();
                p.setCodigo(cod);
                p.setEnunciado(enunciado);
                return p;
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return null;
    }

}
