import { MDBNavbar, MDBNavbarBrand, MDBBreadcrumb, MDBBreadcrumbItem } from 'mdb-react-ui-kit';

const BreadCrump = (pageContext) => {

  const arrayPath = pageContext.pageContext.location.pathname.split('/')
  let BreadcrumbItemKey = 0
  return (
    <MDBNavbar expand='lg' dark bgColor='dark'>
      <MDBNavbarBrand>
        <strong className="white-text">Email Analyzr</strong>
      </MDBNavbarBrand>

      <MDBBreadcrumb>
        {
          arrayPath.map(element => {
            return <MDBBreadcrumbItem key={BreadcrumbItemKey++} onClick={pageContext.pageContext.history.goBack} >{element}</MDBBreadcrumbItem>
          })
        }
      </MDBBreadcrumb>
    </MDBNavbar>
  )
}

export default (BreadCrump)