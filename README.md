
# Gestão de Convidados com Spring 

Management App using Spring Ecossistem (Security, JPA, Spring Boot)



## Features

- Authentication in Memory
- Storage Objects in  Mysql, H2, Postgresql Databases
- Create and List Objects Features


  
## Lessons Learned

- Spring
- Spring Web
- Spring Boot
- Spring Security
- Spring JPA
- Theamleaf

  
## Usage/Examples


## Entity

```
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Convidado implements Serializable {
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue
private Long id;
private String nome;
private Integer quantidadeAcompanhantes;
// getters e setters omitidos
}
```

## Repository
```
package com.algaworks.festa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.festa.model.Convidado;
public interface Convidados extends JpaRepository<Convidado, Long> {
}
```
## Controller
```
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.algaworks.festa.repository.Convidados;
@Controller
public class ConvidadosController {
@Autowired
private Convidados convidados;
@GetMapping("/convidados")
public ModelAndView listar() {
ModelAndView modelAndView = new ModelAndView("ListaConvidados");
modelAndView.addObject("convidados", convidados.findAll());
return modelAndView;
}
}
```
## Authentication
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication
.builders.AuthenticationManagerBuilder;
@Configuration
public class InMemorySecurityConfig {
@Autowired
public void configureGlobal(AuthenticationManagerBuilder builder)
throws Exception {
builder
.inMemoryAuthentication()
.withUser("joao").password("123").roles("USER")
.and()
.withUser("alexandre").password("123").roles("USER")
.and()
.withUser("thiago").password("123").roles("USER");
}
}
```


## Maven Pom.xml File

### mysql-connector-java
```
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

### Spring-Boot Security
```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-security</artifactId>
</dependency>

```


### Thymeleaf
```
<properties>
<!-- ... -->
<thymeleaf.version>3.0.2.RELEASE</thymeleaf.version>
<thymeleaf-layout-dialect.version>2.0.4</thymeleaf-layout-dialect.version>
</properties>
```

### Webjars Locator
```
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>webjars-locator</artifactId>
</dependency>
```

### Jquery

```
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>jquery</artifactId>
    <version>2.1.1</version>
</dependency>
```



## Webjar Scripts imports

```html
<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
```



## HTML View

```html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width" />
<title>Lista de Convidados</title>
<link th:href="@{/webjars/bootstrap/css/bootstrap.min.css}"
	rel="stylesheet" />
<link th:href="@{/webjars/bootstrap/css/bootstrap-theme.min.css}"
	rel="stylesheet" />
</head>
<body>
	<h1>Gerenciamento de Lista Convidados</h1>

	<!-- 	<form class="form-inline" method="POST" style="margin: 20px 0"> -->
	<form class="form-inline" method="POST" th:object="${convidado}" th:action="@{/convidados}" style="margin: 20px 0">
		<div class="form-group">
				
				 <input type="text" class="form-control" placeholder="Nome" th:field="*{nome}" />
				  <input type="text" class="form-control"placeholder="Acompanhantes" th:field="*{quantidadeAcompanhantes}" />

			<button type="submit" class="btn btn-primary">Adicionar</button>
		</div>
	</form>


	<div class="panel panel-default" style="margin: 10px">
		<div class="panel-heading">
			<h1 class="panel-title">Lista de convidados</h1>
		</div>
		<div class="panel-body">
			<table class="table">
				<thead>

					<tr>
						<th>Nome</th>
						<th>Acompanhantes</th>
					</tr>
				</thead>
				<tbody>
					<tr th:each="convidado : ${convidados}">
						<td th:text="${convidado.nome}"></td>
						<td th:text="${convidado.quantidadeAcompanhantes}"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<script th:src="@{/webjars/jquery/jquery.min.js}"></script>
	<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
</body>

</html>
```

## application.properties File

### Datasource and Hibernate JPA Spring
```
spring.datasource.url=jdbc:mysql://localhost/festa
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop
```

### Thymeleaf
```
spring.thymeleaf.mode=html
spring.thymeleaf.cache=false
```
## import.sql File 


```
src/main/resources/import.sql
```


```
insert into convidado (id, nome, quantidade_acompanhantes)
values (1, 'Pedro', 2);
insert into convidado (id, nome, quantidade_acompanhantes)
values (2, 'Maria', 3);
insert into convidado (id, nome, quantidade_acompanhantes)
values (3, 'Ricardo', 1);
```
## Deployment

To deploy this localy project run

```
   http://localhost:8080/convidados.
```

  
To deploy this cloud project run

```
   http://localhost:8080/convidados.
```

 
## License

[MIT](https://choosealicense.com/licenses/mit/)

  
## Acknowledgements

 - [Algworks Official Source-Code](https://github.com/algaworks/ebook-spring-boot)
 - [Algworks Official Content](https://s3.amazonaws.com/algaworks-assets/ebooks/algaworks-livro-spring-boot-v3.0.pdf)

  
## Authors

- [@jcrbsa](https://www.github.com/jcrbsa)

  