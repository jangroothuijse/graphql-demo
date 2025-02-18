package graphql.demo

import org.springframework.stereotype.Service

@Service
class ProjectStatusService {
    fun findStatusForProject(slug: Long): ProjectStatus {
        Thread.sleep(200)
        return ProjectStatus.ACTIVE
    }
}