package graphql.demo

import graphql.schema.DataFetchingEnvironment
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class ProjectController(
    private val projectStatusService: ProjectStatusService
) {
    @QueryMapping
    fun greetings(): String {
        return "Hi"
    }

    @QueryMapping
    fun project(@Argument slug: Long): Project {
        return Project(
            slug = slug,
            name = "Project $slug",
            repositoryUrl = "some.url/$slug",
            status = projectStatusService.findStatusForProject(slug))
    }

    @QueryMapping
    fun lazyProject(@Argument slug: Long,
                    env: DataFetchingEnvironment): Project {
        val status: ProjectStatus = if (env.selectionSet.contains("Project.status")) {
            projectStatusService.findStatusForProject(slug)
        } else {
            ProjectStatus.EOL
        }
        return Project(
            slug = slug,
            name = "Project $slug",
            repositoryUrl = "some.url/$slug",
            status = status)
    }
}