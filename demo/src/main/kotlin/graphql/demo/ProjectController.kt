package graphql.demo

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class ProjectController {
    @QueryMapping
    fun greetings(): String {
        return "Hi"
    }

    @QueryMapping
    fun project(@Argument slug: Long): Project {
        return Project(slug, "Project $slug", "some.url/$slug", ProjectStatus.ACTIVE)
    }
}