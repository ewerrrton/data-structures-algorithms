public class TabelaHashEncadeada {
    private ArrayList<Aluno>[] tabela;
    private final int CAPACIDADE_DEFAULT = 47;
    private final double CONSTANTE = 0.6180339887;
    

    public TabelaHashEncadeada() {
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }

    
    public TabelaHashEncadeada(int capacidade) {
        this.tabela = new ArrayList[capacidade];
    }

    
    private int hashMultiplicacao(Integer chave) {
        double hash = ((chave * CONSTANTE) % 1);
        hash = hash * this.tabela.length;
        return (int) hash;
    }

    public void put(Integer chave, Aluno valor) {
        int hash = hashMultiplicacao(chave);

        ArrayList<Aluno> alunos = this.tabela[hash];

        if(alunos == null) {
            alunos = new ArrayList<Aluno>();
            alunos.add(valor);
            this.tabela[hash] = alunos;

        } else {
            for(int i = 0; i < alunos.size(); i++) {
                if(alunos.get(i).getMatricula().equals(chave)) {
                    alunos.set(i, valor);
                    return;
                }
            }

            alunos.add(valor);
        }

    }
    
    public Aluno get(Integer chave) {
        int hash = hashMultiplicacao(chave);

        ArrayList<Aluno> alunos = this.tabela[hash];

        if(alunos == null || alunos.isEmpty()) {
            return null;
        }

        for(Aluno aluno: alunos) {
            if(aluno.getMatricula().equals(chave)) {
                return aluno;
            }
        }

        return null;
    }

     public boolean containsKey(Integer chave) {
        int hash = hashMultiplicacao(chave);

        ArrayList<Aluno> alunos = this.tabela[hash];

        if(alunos == null || alunos.isEmpty()) {
            return false;
        }

        for(Aluno aluno: alunos) {
            if(aluno.getMatricula().equals(chave)) {
                return true;
            }
        }

        return false;
    }
    public boolean containsValue(Aluno aluno) {
        for(ArrayList<Aluno> alunos: this.tabela) {
            if(alunos != null) {
                for(Aluno a: alunos) {
                    if(a.equals(aluno)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
 
    public Aluno remove(int chave) {
        int hash = hashMultiplicacao(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        Iterator<Aluno> it = alunos.iterator();
        Aluno atual = null;

        while (it.hasNext()) {
                atual = it.next();
                if (atual.getMatricula().equals(chave)) {
                    it.remove();
                    return atual;
                }
        }

        return atual;
    }
}
