package grails_logviewer

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"logViewer")

//        "/"(view:"/index")
//        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
