**ScreenMatch** é um projeto desenvolvido em Java utilizando o Maven para gerenciamento de dependências. O principal objetivo deste projeto é implementar funcionalidades relacionadas à manipulação e análise de dados de séries. O sistema permite a leitura, processamento e exibição de informações relevantes, como título, ano de lançamento, duração e gênero das séries. Além disso, o projeto explora conceitos fundamentais de programação orientada a objetos (POO), como herança, encapsulamento e polimorfismo, aplicados ao domínio de entretenimento focado em séries.

### Funcionalidades principais:
- Leitura e processamento de dados de séries.
- Cálculo e exibição de informações agregadas como média de duração das séries.
- Implementação de uma interface amigável para interações básicas com os dados das séries.
- Integração com arquivos de configuração padrão do Maven (`pom.xml`).
- Configuração de variáveis de ambiente para conexão com o banco de dados.

### Estrutura do Projeto:
- **src/**: Contém o código-fonte do projeto, dividido em pacotes que separam as diferentes responsabilidades.
- **pom.xml**: Arquivo de configuração do Maven que gerencia as dependências e plugins do projeto.
- **target/**: Diretório gerado pelo Maven contendo os artefatos de build.
- **application.properties**: Arquivo de configuração onde as variáveis de ambiente do banco de dados são definidas.

### Requisitos:
- **Java 11** ou superior.
- **Maven 3.6.0** ou superior.
- Banco de dados PostgreSQL configurado.

### Configuração das Variáveis de Ambiente:
Antes de executar o projeto, você deve configurar as seguintes variáveis de ambiente:

- `DB_HOST`: Host do banco de dados PostgreSQL.
- `DB_NAME`: Nome do banco de dados.
- `DB_USER`: Usuário do banco de dados.
- `DB_PASSWORD`: Senha do usuário do banco de dados.

Essas variáveis são referenciadas no arquivo `application.properties` da seguinte forma:

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

### Como Executar:
1. Clone o repositório:
   ```bash
   git clone github.com/Kic-Xp/screenMatch-completo
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd screenmatch
   ```
3. Configure as variáveis de ambiente mencionadas acima.
4. Compile o projeto utilizando o Maven:
   ```bash
   mvn clean install
   ```
5. Execute a aplicação:
   ```bash
   mvn exec:java
   ```


  ### Agradecimentos:
Este projeto foi inspirado e desenvolvido com o apoio dos cursos da Alura. Agradeço a toda a equipe da Alura pelo conteúdo de qualidade e por proporcionar uma excelente plataforma de aprendizado.

