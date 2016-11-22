package com.sistema.bd;

import com.sistema.bean.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//As exceções devem ser propagadas para a camada de apresentação, ou seja, deve ser utilizado throws em cada um dos métodos
public class ProfessorDAO {

    public void delete(Professor prof) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from professores where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prof.getCodProf());
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

    public void insert(Professor prof) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "insert into professores (codigo,nome,senha,sexo,data,email,telefone,endereco,especializacao) values(?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prof.getCodProf());
            ps.setString(2, prof.getNomeProf());
            ps.setString(3, prof.getSenhaProf());
            ps.setString(4, prof.getSexo());
            ps.setString(5, prof.getDatanasc());
            ps.setString(6, prof.getEmail());
            ps.setString(7, prof.getTelefone());
            ps.setString(8, prof.getEndereco());
            ps.setString(9, prof.getEspecializacao());

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

    public void update(Professor prof) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "update professores set nome = ? where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, prof.getNomeProf());
            ps.setInt(2, prof.getCodProf());
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

    public List<Professor> getAll() {
        List<Professor> lista = new ArrayList<Professor>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select codigo, nome from professores";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer codigo = rs.getInt(1);
                String nome = rs.getString(2);
                Professor p = new Professor();
                p.setCodProf(codigo);
                p.setNomeProf(nome);
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

    public Professor getProfessor(Integer codigo) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select * from professores where codigo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Integer cod = rs.getInt(1);
                String nome = rs.getString(2);
                String senha = rs.getString(3);
                String sexo = rs.getString(4);
                String datanasc = rs.getString(5);
                String email = rs.getString(6);
                String telefone = rs.getString(7);
                String endereco = rs.getString(8);
                String Especializacao = rs.getString(9);

                Professor p = new Professor();
                p.setCodProf(cod);
                p.setNomeProf(nome);
                p.setSenhaProf(senha);
                p.setSexo(sexo);
                p.setDataNasc(datanasc);
                p.setEmail(email);
                p.setTelefone(telefone);
                p.setEndereco(endereco);
                p.setEspecializacao(Especializacao);

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
