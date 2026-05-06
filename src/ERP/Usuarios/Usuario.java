    package ERP.Usuarios;

    public class Usuario {
        private String nome;
        private String tipo;
        private String senha;
        private int id;


        public Usuario(String n, String t, String s, int i) {
            this.nome = n;
            this.tipo = t;
            this.senha = s;
            this.id = i;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String n) {
            this.nome = n;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String t) {
            this.tipo = t;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String s) {
            this.senha = s;
        }

        public int getId() {
            return id;
        }

    }
